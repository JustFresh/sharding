package com.xiudoua.micro.study.config;

import java.io.Serializable;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

import com.sun.corba.se.spi.ior.Identifiable;


/**
 * @desc 自定义ID生成器
 * @author JustFresh
 * @time 2021年2月19日 下午9:19:52
 */
public class AssignedIdentityGenerator extends IdentityGenerator {
	 
    public Serializable generate(SessionImplementor session, Object obj) {
        if(obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            if(id != null) {
                return id;
            }
        }
        return super.generate(session, obj);
    }
}