# Redes Avanzadas
- Ariel Alcocer Rodriguez
- Carrera de Ingeniería Informática

A continuación se detalla la configuración de cada uno de los dispositivos de la red.

## Router1A
```sh
Router#show running-config 
Building configuration...

Current configuration : 922 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 192.168.0.1 255.255.255.224
 ip helper-address 210.0.0.1
 duplex auto
 speed auto
!
interface FastEthernet0/1
 no ip address
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 1.0.0.1 255.255.255.252
!
interface Serial0/0/1
 bandwidth 64
 ip address 2.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/1/0
 ip address 3.0.0.1 255.255.255.252
!
interface Serial0/1/1
 no ip address
!
interface Vlan1
 no ip address
 shutdown
!
router rip
 version 2
 passive-interface FastEthernet0/0
 network 1.0.0.0
 network 2.0.0.0
 network 3.0.0.0
 network 192.168.0.0
 no auto-summary
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router2A
```sh
Router#show running-config 
Building configuration...

Current configuration : 843 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 4.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 210.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 7.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 bandwidth 64
 ip address 3.0.0.2 255.255.255.252
 clock rate 64000
!
interface Vlan1
 no ip address
 shutdown
!
router rip
 version 2
 passive-interface FastEthernet0/1
 network 3.0.0.0
 network 4.0.0.0
 network 7.0.0.0
 network 210.0.0.0
 no auto-summary
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router3A
```sh
Router#show running-config 
Building configuration...

Current configuration : 779 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 200.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 8.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 6.0.0.2 255.255.255.252
!
interface Serial0/0/1
 ip address 7.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router rip
 version 2
 passive-interface FastEthernet0/0
 network 6.0.0.0
 network 7.0.0.0
 network 8.0.0.0
 network 200.0.0.0
 no auto-summary
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router4A
```sh
Router#show running-config 
Building configuration...

Current configuration : 1138 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 8.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 5.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 1.0.0.2 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 bandwidth 64
 ip address 10.0.0.1 255.255.255.252
 clock rate 64000
!
interface Vlan1
 no ip address
 shutdown
!
router bgp 10
 bgp log-neighbor-changes
 no synchronization
 neighbor 10.0.0.2 remote-as 100
 network 10.0.0.0 mask 255.255.255.252
 network 192.168.0.0 mask 255.255.255.224
 network 210.0.0.0 mask 255.255.255.252
 network 200.0.0.0 mask 255.255.255.252
 redistribute connected 
!
router rip
 version 2
 network 1.0.0.0
 network 5.0.0.0
 network 8.0.0.0
 default-information originate
 no auto-summary
!
ip classless
ip route 0.0.0.0 0.0.0.0 Serial0/0/1 
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router0A
```sh
Router#show running-config 
Building configuration...

Current configuration : 740 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 4.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 5.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 6.0.0.1 255.255.255.252
!
interface Serial0/0/1
 ip address 2.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router rip
 version 2
 network 2.0.0.0
 network 4.0.0.0
 network 5.0.0.0
 network 6.0.0.0
 no auto-summary
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router1B
```sh
Router#show running-config 
Building configuration...

Current configuration : 891 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 no ip address
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 31.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 30.0.0.1 255.255.255.252
!
interface Serial0/0/1
 ip address 10.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router bgp 100
 bgp log-neighbor-changes
 no synchronization
 neighbor 10.0.0.1 remote-as 10
 neighbor 30.0.0.2 remote-as 400
 neighbor 31.0.0.2 remote-as 200
 network 10.0.0.0 mask 255.255.255.252
 network 30.0.0.0 mask 255.255.255.252
 network 31.0.0.0 mask 255.255.255.252
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router2B
```sh
Router#show running-config 
Building configuration...

Current configuration : 1019 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 110.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 31.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 33.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 bandwidth 64
 ip address 32.0.0.1 255.255.255.252
 clock rate 64000
!
interface Vlan1
 no ip address
 shutdown
!
router bgp 200
 bgp log-neighbor-changes
 no synchronization
 neighbor 31.0.0.1 remote-as 100
 neighbor 33.0.0.2 remote-as 400
 neighbor 32.0.0.2 remote-as 300
 network 31.0.0.0 mask 255.255.255.252
 network 32.0.0.0 mask 255.255.255.252
 network 33.0.0.0 mask 255.255.255.252
 network 110.0.0.0 mask 255.255.255.252
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router3B
```sh
Router#show running-config 
Building configuration...

Current configuration : 923 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 no ip address
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 34.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 20.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 ip address 32.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router bgp 300
 bgp log-neighbor-changes
 no synchronization
 neighbor 32.0.0.1 remote-as 200
 neighbor 34.0.0.1 remote-as 400
 neighbor 20.0.0.2 remote-as 20
 network 20.0.0.0 mask 255.255.255.252
 network 34.0.0.0 mask 255.255.255.252
 network 32.0.0.0 mask 255.255.255.252
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router4B
```sh
Router#show running-config 
Building configuration...

Current configuration : 924 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 34.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 no ip address
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 30.0.0.2 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 ip address 33.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router bgp 400
 bgp log-neighbor-changes
 no synchronization
 neighbor 34.0.0.2 remote-as 300
 neighbor 33.0.0.1 remote-as 200
 neighbor 30.0.0.1 remote-as 100
 network 30.0.0.0 mask 255.255.255.252
 network 33.0.0.0 mask 255.255.255.252
 network 34.0.0.0 mask 255.255.255.252
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router1C
```sh
Router#show running-config 
Building configuration...

Current configuration : 1381 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 192.168.1.1 255.255.255.224
 ip helper-address 18.0.0.2
 duplex auto
 speed auto
!
interface FastEthernet0/1
 no ip address
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 11.0.0.1 255.255.255.252
!
interface Serial0/0/1
 bandwidth 64
 ip address 12.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/1/0
 ip address 20.0.0.2 255.255.255.252
!
interface Serial0/1/1
 bandwidth 64
 ip address 13.0.0.1 255.255.255.252
 clock rate 64000
!
interface Vlan1
 no ip address
 shutdown
!
router ospf 100
 log-adjacency-changes
 redistribute bgp 20 subnets 
 passive-interface FastEthernet0/0
 network 192.168.1.0 0.0.0.31 area 0
 network 11.0.0.0 0.0.0.3 area 0
 network 12.0.0.0 0.0.0.3 area 0
 network 13.0.0.0 0.0.0.3 area 0
 default-information originate
!
router bgp 20
 bgp log-neighbor-changes
 no synchronization
 neighbor 20.0.0.1 remote-as 300
 network 20.0.0.0 mask 255.255.255.252
 network 100.0.0.0 mask 255.255.255.252
 network 192.168.1.0 mask 255.255.255.224
 redistribute ospf 100 
!
ip classless
ip route 0.0.0.0 0.0.0.0 Serial0/1/0 
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router2C
```sh
Router#show running-config 
Building configuration...

Current configuration : 877 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 14.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 100.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 13.0.0.2 255.255.255.252
!
interface Serial0/0/1
 bandwidth 64
 ip address 17.0.0.1 255.255.255.252
 clock rate 64000
!
interface Vlan1
 no ip address
 shutdown
!
router ospf 200
 log-adjacency-changes
 passive-interface FastEthernet0/1
 network 100.0.0.0 0.0.0.3 area 0
 network 17.0.0.0 0.0.0.3 area 0
 network 14.0.0.0 0.0.0.3 area 0
 network 13.0.0.0 0.0.0.3 area 0
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router3C
```sh
Router#show running-config 
Building configuration...

Current configuration : 910 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
ip dhcp excluded-address 192.168.1.1
!
ip dhcp pool dhcpServerPoolRight
 network 192.168.1.0 255.255.255.224
 default-router 192.168.1.1
 dns-server 110.0.0.1
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 no ip address
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 18.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 ip address 16.0.0.2 255.255.255.252
!
interface Serial0/0/1
 ip address 17.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router ospf 300
 log-adjacency-changes
 network 17.0.0.0 0.0.0.3 area 0
 network 16.0.0.0 0.0.0.3 area 0
 network 18.0.0.0 0.0.0.3 area 0
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router4C
```sh
Router#show running-config 
Building configuration...

Current configuration : 785 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 18.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 15.0.0.1 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 11.0.0.2 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 no ip address
!
interface Vlan1
 no ip address
 shutdown
!
router ospf 400
 log-adjacency-changes
 network 11.0.0.0 0.0.0.3 area 0
 network 15.0.0.0 0.0.0.3 area 0
 network 18.0.0.0 0.0.0.3 area 0
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
## Router0C
```sh
Router#show running-config 
Building configuration...

Current configuration : 840 bytes
!
version 12.4
no service timestamps log datetime msec
no service timestamps debug datetime msec
no service password-encryption
!
hostname Router
!
!
!
!
!
!
!
!
!
!
!
!
!
!
spanning-tree mode pvst
!
!
!
!
interface FastEthernet0/0
 ip address 14.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface FastEthernet0/1
 ip address 15.0.0.2 255.255.255.252
 duplex auto
 speed auto
!
interface Serial0/0/0
 bandwidth 64
 ip address 16.0.0.1 255.255.255.252
 clock rate 64000
!
interface Serial0/0/1
 ip address 12.0.0.2 255.255.255.252
!
interface Vlan1
 no ip address
 shutdown
!
router ospf 500
 log-adjacency-changes
 network 12.0.0.0 0.0.0.3 area 0
 network 14.0.0.0 0.0.0.3 area 0
 network 15.0.0.0 0.0.0.3 area 0
 network 16.0.0.0 0.0.0.3 area 0
!
ip classless
!
!
!
!
!
!
!
line con 0
!
line aux 0
!
line vty 0 4
 login
!
!
!
end
```
<!-- ## DHCP Server -->
<!-- ![DNS Server](https://github.com/aralco/umss/blob/master/redesavanzadas/resources/DNSServer.PNG) -->
