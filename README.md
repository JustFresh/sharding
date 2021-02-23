# ShardingJDBC分库分表学习DEMO

## 1.ShardingJDBC《一》概念描述

### 前言
### 1.1.为什么需要分库分表？
### 1.2.水平拆分与垂直拆分？
- 1.2.1.垂直分库
- 1.2.2.垂直分表
- 1.2.3.水平分库
- 1.2.4.水平分表

### 1.3.水平拆分与垂直拆分？
- 1.3.1.架构图
- 1.3.2.名词说明

### 1.4.四种分片算法
- 1.4.1.精确分片算法
- 1.4.2.范围分片算法
- 1.4.3.复合分片算法
- 1.4.4.Hint分片算法

### 1.5.五种分片策略
- 1.5.1.标准分片策略
- 1.5.2.复合分片策略
- 1.5.3.行表达式分片策略
- 1.5.4.Hint分片策略
- 1.5.5.不分片策略

## 2.ShardingJDBC《二》基础实现篇
### sharding-normal模块实现
### 2.1.实现目标
### 2.2.表结构设计
- 2.2.1.基础配置表TB_CONFIG
- 2.2.2.用户表TB_USER
- 2.2.3.收货地址表TB_ADDRESS

### 2.3.分库分表实现
- 2.3.1.项目实现使用组件
- 2.3.2.项目结构
- 2.3.3.分表分库核心部分

### 2.4.效果演示
- 2.4.1.初始数据库及表结构
- 2.4.2.单测后效果


## 3.ShardingJDBC《三》自定义扩展篇
### sharding-custom模块实现
### 3.1.分布式主键
- 3.1.1.数据库存储
- 3.1.2.Redis生成
- 3.1.3.自带雪花算法整合

### 3.2.自定义分片策略
- 3.2.1.自定义分库类
- 3.2.2.自定义分表类
- 3.2.3.添加配置文件
- 3.2.4.执行结果

## 4.ShardingJDBC《四》动态扩容
### sharding-double-expand模块实现
### 4.1.简单粗暴一次性搞定
### 4.2.翻倍式扩容
### 4.3.不停机动态扩容
- 4.3.1.实现思想
- 4.3.2.实现目标
- 4.3.3.实现过程
