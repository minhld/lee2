package com.minh.lee2.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Runtime information about the application environment")
public record SystemInfo(
        @Schema(description = "Java runtime version", example = "21.0.1")
        String javaVersion,

        @Schema(description = "Embedded Tomcat server version", example = "Apache Tomcat/11.0.21")
        String tomcatVersion,

        @Schema(description = "Operating system information")
        SystemDetails system
) {
    @Schema(description = "Operating system details")
    public record SystemDetails(
            @Schema(description = "Operating system version", example = "26.5.1")
            String version,

            @Schema(description = "Operating system name", example = "Mac OS X")
            String name,

            @Schema(description = "CPU architecture", example = "aarch64")
            String architecture
    ) {
    }
}
