package com.company.project.core.common;

/**
 * 
* @ClassName: ProjectConstant  
* @Description: 项目常量
* @author duanzhiwei
* @date 2018年1月16日 上午11:51:51  
*
 */
public final class ProjectConstant {
    /**
     * BASE_PACKAGE:项目基础包名称，根据自己公司的项目修改
     */
    public static final String BASE_PACKAGE = "com.company.project";
    /**
     * MODEL_PACKAGE:Model所在包
     */
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".domain.model";
    /**
     * MAPPER_PACKAGE:Mapper所在包
     */
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";
    /**
     * SERVICE_PACKAGE:Service所在包
     */
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
    /**
     * SERVICE_IMPL_PACKAGE:ServiceImpl所在包
     */
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
    /**
     * CONTROLLER_PACKAGE:Controller所在包
     */
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";
    /**
     * MAPPER_INTERFACE_REFERENCE:Mapper插件基础接口的完全限定名
     */
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.common.Mapper";
    /**
     * TOKEN_HEADER:token在header中的字段
     */
    public static final String TOKEN_HEADER = "X-Auth-Token";
    /**
     * TOKEN_CACHE_PRIFIX:token在缓存中的前缀
     */
    public static final String TOKEN_CACHE_PRIFIX = "token";
    /**
     * TOKEN_EXPIRETIME:token失效时间，单位秒
     */
    public static final int TOKEN_EXPIRETIME = 1800;
}
