FROM centos:7
MAINTAINER uryyyyyyy <koki305@gmail.com>
RUN yum update -y
RUN yum clean all
RUN yum install tcl gcc wget make vim net-tools -y

RUN wget -c -O /tmp/jdk-8u65-linux-x64.rpm --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u65-b17/jdk-8u65-linux-x64.rpm
RUN yum -y localinstall /tmp/jdk-8u65-linux-x64.rpm

# zookeeper install
RUN wget http://ftp.jaist.ac.jp/pub/apache/zookeeper/zookeeper-3.4.6/zookeeper-3.4.6.tar.gz
RUN tar zxvf zookeeper-3.4.6.tar.gz
WORKDIR zookeeper-3.4.6
RUN cp conf/zoo_sample.cfg conf/zoo.cfg
# RUN bin/zkServer.sh start

CMD [ "/bin/bash" ]

