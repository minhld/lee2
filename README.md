SETUP COSMOS DB SERVER

To check if docker is working or not
```
docker ps
```

1. Add remote IP and Domain name to the cosmos config file

Go to the container console 
```
docker exec -it cosmosdb sh
```
Add the contents
```
cat > /scripts/certs/gen_cert.conf <<'EOF'
# gen_cert.conf

[ req ]
distinguished_name = req_distinguished_name
prompt             = no
default_bits       = 2048

[ req_distinguished_name ]
C  = US
ST = WA
O  = SqlPostgresHostConsole
CN = macs-iMac.local

[ v3_root_ca ]
basicConstraints = critical, CA:TRUE
keyUsage = critical, keyCertSign, cRLSign
subjectKeyIdentifier = hash

[ v3_ca ]
authorityKeyIdentifier = keyid,issuer
basicConstraints = CA:FALSE
keyUsage = digitalSignature, keyEncipherment, dataEncipherment
extendedKeyUsage = serverAuth, clientAuth
subjectAltName = @alt_names
subjectKeyIdentifier = hash

[ alt_names ]
DNS.1 = localhost
DNS.2 = macs-iMac.local
DNS.3 = 127.0.0.1
IP.1 = 127.0.0.1
IP.2 = 192.168.1.71
EOF
```
Verify the file content

```
cat /scripts/certs/gen_cert.conf
```
It should have something like below

``` 
DNS.2 = macs-iMac.local
IP.2 = 192.168.1.71
```
2. Delete the generated certificates

Using below commands

``` 
rm -f /scripts/certs/domain.*
rm -f /scripts/certs/rootCA.*
```
Then exit the container's console

3. Restart the container

``` 
docker restart cosmosdb
```

4. Verify the new certificate

```
docker exec cosmosdb openssl x509 \
    -in /scripts/certs/domain.crt \
    -text -noout | grep -A5 "Subject Alternative Name"
```

It should show something like below

``` 
X509v3 Subject Alternative Name:
    DNS:localhost
    DNS:macs-iMac.local
    DNS:127.0.0.1
    IP Address:127.0.0.1
    IP Address:192.168.1.71
```

5. Other commands

```
docker stop cosmosdb
```

To run the cosmosdb
```
docker run -d \
    --name cosmosdb \
    -p 8081:8081 \
    -p 8080:8080 \
    -p 1234:1234 \
    -e GATEWAY_PUBLIC_ENDPOINT=192.168.1.71 \
    mcr.microsoft.com/cosmosdb/linux/azure-cosmos-emulator:vnext-latest \
    --protocol https
```

To check if GATEWAY_PUBLIC_ENDPOINT has the correct value
```
docker inspect cosmosdb --format='{{range .Config.Env}}{{println .}}{{end}}' | grep GATEWAY
```