# bss
营销系统代码仓库
工程基于Maven管理，通过work-parent进行组织，work-tools、work-dao、work-auth为基础模块，
其中work-tools为工具类集合，work-dao为各类orm/db抽象实现work-auth为安全验证模块
work-api为外部接口模块，work-schedule为任务调度模块，work-webapi为内部接口模块、work-web为项目按功能模块划分子项目（合并了work-webapi模块）。
