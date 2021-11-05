#!/usr/bin/python3
from scapy.all import *
E = Ether(dst='ff:ff:ff:ff:ff', src='srcMAC')
A = ARP(hwsrc='srcMAC', psrc='srcIP', hwdst='dstMAC', pdst='dstIP')
pkt = E/A
pkt.show()
sendp(pkt)
