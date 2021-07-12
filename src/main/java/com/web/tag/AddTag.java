package com.web.tag;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
<h1>
           <my:add x="10.5" y="20" />
        </h1>
        <h1>
            <my:add x="10.5" y="20" z="30.5" />
        </h1>
*/
public class AddTag extends SimpleTagSupport 
                    implements DynamicAttributes {
    private Map<String, Double> map = new LinkedHashMap<>();
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        map.put(localName, Double.parseDouble(value+""));
        
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
       double sum = map.entrySet().stream().mapToDouble(Entry::getValue).sum();//(e->e.getVaule);
                
                
       
        out.println(sum);
    }
    
    
    
}