load("//tools/bzl:maven_jar.bzl", "maven_jar")

def external_plugin_deps():
    maven_jar(
        name = "wiremock",
        artifact = "com.github.tomakehurst:wiremock-standalone:2.21.0",
        sha1 = "68807a39d80a19222316c57bf9a9d987ed26a0e3",
    )

    maven_jar(
        name = "mockito",
        artifact = "org.mockito:mockito-core:2.24.0",
        sha1 = "969a7bcb6f16e076904336ebc7ca171d412cc1f9",
        deps = [
            "@byte-buddy//jar",
            "@byte-buddy-agent//jar",
            "@objenesis//jar",
        ],
    )

    BYTE_BUDDY_VERSION = "1.9.7"

    maven_jar(
        name = "byte-buddy",
        artifact = "net.bytebuddy:byte-buddy:" + BYTE_BUDDY_VERSION,
        sha1 = "8fea78fea6449e1738b675cb155ce8422661e237",
    )

    maven_jar(
        name = "byte-buddy-agent",
        artifact = "net.bytebuddy:byte-buddy-agent:" + BYTE_BUDDY_VERSION,
        sha1 = "8e7d1b599f4943851ffea125fd9780e572727fc0",
    )

    maven_jar(
        name = "objenesis",
        artifact = "org.objenesis:objenesis:2.6",
        sha1 = "639033469776fd37c08358c6b92a4761feb2af4b",
    )

    maven_jar(
        name = "jgroups",
        artifact = "org.jgroups:jgroups:3.6.15.Final",
        sha1 = "755afcfc6c8a8ea1e15ef0073417c0b6e8c6d6e4",
    )
