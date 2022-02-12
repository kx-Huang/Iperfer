# Iperfer

A tool used to measure network bandwidth using TCP and sockets written by Java.

## Developers
- Kexuan Huang (kexuanh@cs.wisc.edu)
- Qinhang Wu (qinhang@cs.wisc.edu)

## Remarks
This is a course project of CS640 Introduction to Computer Networks in Univerity of Wisconsin-Madison.

## How to Build Iperfer
```sh
cd src/
make
```

## How to Use Iperfer
Configure and Run Iperfer as server and client on each end of the network to be measured.

1. Client Mode

    ```sh
    $ java Iperfer -c -h [server hostname] -p [server port] -t [time]
    ```

    - `-c` indicates this is the *Iperfer* **client** which should generate data.
    - Server hostname is the hostname or IP address of the *Iperfer* **server** which will consume data.
    - Server port is the port on which the remote host is waiting to consume data.
    - Server port should be in the range **1024 ≤ server port ≤ 65535**.
    - Time is the duration in **seconds** for which data should be generated.
    - All arguements are needed to be present.

2. Server Mode

    ```sh
    $ java Iperfer -s -p [listen port]
    ```

    - `-s` indicates this is the *Iperfer* **server** which should consume data.
    - Listen port is the port on which the host is waiting to consume data.
    - The port should be in the range **1024 ≤ listen port ≤ 65535**.
    - All arguements are needed to be present.

## Sample Output
1. Client Mode

    ```log
    sent=58629 KB rate=21.253 Mbps
    ```

2. Server Mode

    ```log
    received=58629 KB rate=20.947 Mbps
    ```
