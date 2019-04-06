package com.shiro.test.filter;

import org.apache.shiro.config.Ini;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang on 2019/3/21.
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean{

    private static final String ROLE_STRING="roles[{0}]";
    private String ss = "";

    @Override
    public void setFilterChainDefinitions(String definitions) {
        ss = definitions;
        Ini ini = new Ini();
        ini.load(definitions);
        //did they explicitly state a 'urls' section?  Not necessary, but just in case:
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            //no urls section.  Since this _is_ a urls chain definition property, just assume the
            //default section contains only the definitions:
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        //动态从数据库读取新的数据
        Map<String,String[]> map = new HashMap<>();
        map.put("/dotest1.html",new String[]{"test"});
        map.put("/dotest2.html",new String[]{"test","guest"});
//        map.put("/dotest3.html",new String[]{"admin"});

        for (String url : map.keySet()){
            String[] roles=map.get(url);
            StringBuilder sb = new StringBuilder();
            for (String role : roles){
                sb.append(role).append(",");
            }
            String str = sb.substring(0,sb.length()-1);
            section.put(url, MessageFormat.format(ROLE_STRING,str));
        }
        setFilterChainDefinitionMap(section);
    }

    public void update(){
        //避免线程冲突
        synchronized (this) {
            try {
                AbstractShiroFilter shiroFilter= (AbstractShiroFilter)this.getObject();
                PathMatchingFilterChainResolver resolver =
                        (PathMatchingFilterChainResolver)shiroFilter.getFilterChainResolver();
                DefaultFilterChainManager manager =
                        (DefaultFilterChainManager)resolver.getFilterChainManager();
                manager.getFilterChains().clear();
                this.getFilterChainDefinitionMap().clear();
                this.setFilterChainDefinitions(ss);
                this.setFilterChainDefinitions("/dotest3.html=authc,roles[admin]");

                Map<String, String> chains = getFilterChainDefinitionMap();
                if (!CollectionUtils.isEmpty(chains)) {
                    for (Map.Entry<String, String> entry : chains.entrySet()) {
                        String url = entry.getKey();
                        String chainDefinition = entry.getValue();
                        manager.createChain(url, chainDefinition);
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}
