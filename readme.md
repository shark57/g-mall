1.在升级springboot，springclould，springcliuldAlibaba版本的过程中，雨

Nacos2.0版本相比1.X新增了gRPC的通信方式，因此需要增加2个端口。
新增端口是在配置的主端口(server.port)基础上，进行一定偏移量自动生成。
2.在使用springboot2.6.4的过程中各个版本的匹配出现问题，网管组件不能使用