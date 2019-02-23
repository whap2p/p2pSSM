package com.zking.p2pSSM.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.p2pSSM.utils.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PagerAspect {
    /**
     *切面针对于哪些类方法
     * 返回类型不限
     * 任意包
     * 以Service的接口
     * 以Pager结尾的方法
     * 传人参数不限
     * @param args
     * @return
     * @throws Throwable
     */
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable{
       //获取*Pager方法的参数
        Object[] params=args.getArgs();
        //如果*Pager方法中含有pagebean，意味着需要分页
        PageBean pageBean=null;
        for (Object param : params){
            if(param instanceof  PageBean){
                pageBean=(PageBean) param;
                break;
            }
        }
        if(pageBean!=null&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        Object proceed=args.proceed(params);
        if(pageBean!=null&&pageBean.isPagination()){
            PageInfo pageInfo=new PageInfo((List) proceed);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return  proceed;
    }
}
