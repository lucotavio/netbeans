<#if package?? && package != "">
package ${package};

</#if>
<#if superclass?? && superclass != "" && !superclass?starts_with("java.lang") && !superclass?matches(package + "\\.\\w+")>
import ${superclass};
</#if>
<#if interfaces?? && interfaces != "">
    <#list "${interfaces}"?split("\n") as interface>
        <#if interface?? && interface != "" && !interface?starts_with("java.lang") && !interface?matches(package + "\\.\\w+")>
import ${interface};
        </#if>
    </#list>

</#if>
<#if superclass?? && superclass != "">
    <#assign extension = "${superclass}"[("${superclass}"?last_index_of(".") + 1)..]>
</#if>
<#if interfaces?? && interfaces != "">
    <#assign implementation = "">
    <#list "${interfaces}"?split("\n") as interface>
        <#assign implementation += "${interface}"[("${interface}"?last_index_of(".") + 1)..] + ", ">
    </#list>
    <#assign implementation = "${implementation}"?remove_ending(", ")>
</#if>
public class ${name}<#if extension?? && extension != ""> extends ${extension}</#if><#if implementation?? && implementation != ""> implements ${implementation}</#if> {

    public static void main(String[] args) {
        
    }

}
