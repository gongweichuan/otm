package cn.net.gwc.c.util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p>文件名称：ObjectInfo.java</p>
 * <p>文件描述：</p>
 * <p>版权所有： 版权所有(C)2007-2017</p>
 * <p>公    司： 与龙共舞独立工作室</p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 * <p>完成日期：2015-1-8</p>
 * <p>修改记录1：</p>
 * <pre>
 *  修改日期：

 *  版本号：
 *  修改人：
 *  修改内容：

 * </pre>
 * <p>修改记录2：</p>
 *
 * @version 1.0
 * @author 龚为川

 * @email  gongweichuan(AT)gmail.com
 */
public class ObjectInfo
{
    public static String space(int count){
        StringBuffer indent = new StringBuffer();
        for(int i=0;i<count;i++){indent.append(" ");}
        return indent.toString();
    }
    
    public static String plus(String name){
        return name==null ? "" : (name+":");
    }
    
    public static String className(Object obj){
        return obj==null ? null : className(obj.getClass());
    }

    public static String className(Class cls){
        return className(cls.getName());
    }

    public static String className(String className){
        return className.substring(className.lastIndexOf(".")+1);
    }

    public static String objectSimpleName(Object obj){
        if(obj == null){
            return null;
        }else{
            return className(obj) + '@' + Integer.toHexString(obj.hashCode());
        }
    } 

    public static String objectFullName(Object obj){
        if(obj == null){
            return null;
        }else{
            return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
        }
    }

    /**
     * 将obj的内容转换成字符串(深度限制缺省为10个字符)
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        return createString(null,className(obj),obj,0,10);
    }
  
    /**
     * 将obj的内容转换成字符串
     * @param obj
     * @param limit 深度限制,缩进字符数
     * @return
     */
    public static String toString(Object obj,int limit){
        return createString(null,className(obj),obj,0,limit);
    }
    
    private static String createString(String name, String type, Object obj, int indent, int limit){
        if(obj == null) return space(indent)+plus(name)+type+"(null)\n";
         
        String objValue = String.valueOf(obj);
        StringBuffer info = new StringBuffer();
        try{
            Class objClass = obj.getClass();
            //Field[] fields = objClass.getDeclaredFields();
            if(objClass.isPrimitive() ||
               objClass.equals(java.lang.String.class) ||
               objClass.equals(java.lang.Boolean.class) ||
               objClass.equals(java.lang.Byte.class) ||
               objClass.equals(java.lang.Character.class) ||
               objClass.equals(java.lang.Short.class) ||
               objClass.equals(java.lang.Integer.class) ||
               objClass.equals(java.lang.Long.class) ||
               objClass.equals(java.lang.Float.class) ||
               objClass.equals(java.lang.Double.class) ||
               objClass.equals(java.math.BigInteger.class) ||
               objClass.equals(java.math.BigDecimal.class)){
                info.append(space(indent)+plus(name)+type+"("+obj+")\n");
            }
            else if(obj instanceof java.util.Date)
            {
                info.append(space(indent)+plus(name)+type+"("+obj+")\n");
            }
            else if(obj instanceof java.util.Date)
            {
                info.append(space(indent)+plus(name)+type+"("+obj+")\n");
            }
            else if(indent >= limit)
            {
                info.append(space(indent)+plus(name)+type+"(...)\n");
            }
            else if(objClass.isArray() && obj instanceof Object[])
            {
                //info.append(space(indent)+plus(name)+type+"\n");
                info.append(space(indent)+plus(name)+objectFullName(obj)+"\n");
                info.append(space(indent)+"[\n");

                Object[] values = (Object[]) obj;
                info.append(space(indent+2)+"---values("+values.length+")---\n");
                
                for(int i=0;i<values.length;i++){
                    Object value = values[i];
                    info.append(createString("["+(i+1)+"]",className(objClass.getComponentType()),value,indent+2,limit));
                }
                
                info.append(space(indent)+"]\n");
            }
            else if(obj instanceof java.util.Collection)
            {
                //info.append(space(indent)+plus(name)+type+"\n");
                info.append(space(indent)+plus(name)+objectFullName(obj)+"\n");
                info.append(space(indent)+"[\n");
                
                Collection values = (Collection) obj;
                info.append(space(indent+2)+"---values("+values.size()+")---\n");
                
                int i=0;
                for (Iterator iterator = values.iterator(); iterator.hasNext();i++) {
                    Object value = iterator.next();
                    info.append(createString("("+(i+1)+")",className(value),value,indent+2,limit));
                }
                
                info.append(space(indent)+"]\n");
            }
            else if(obj instanceof java.util.Map)
            {
                //info.append(space(indent)+plus(name)+type+"\n");
                info.append(space(indent)+plus(name)+objectFullName(obj)+"\n");
                info.append(space(indent)+"[\n");
                
                Map values = (Map) obj;
                    Set set = values.keySet();
                info.append(space(indent+2)+"---values("+values.size()+")---\n");
                
                for (Iterator iterator = set.iterator(); iterator.hasNext();) {
                    String key = (String) iterator.next();
                    Object value = values.get(key);
                    info.append(createString(key,className(value),value,indent+2,limit));
                }
                
                info.append(space(indent)+"]\n");
            }
            else if(objValue.indexOf("@")<0)
            {
                info.append(space(indent)+plus(name)+type+"("+obj+")\n");
            }
            else
            {
                //info.append(space(indent)+plus(name)+type+"\n");
                info.append(space(indent)+plus(name)+objectFullName(obj)+"\n");
                info.append(space(indent)+"{\n");
                
                Method[] methods = objClass.getMethods();
                info.append(space(indent+2)+"---methods("+methods.length+")---\n");
                
                for(int i=0;i<methods.length;i++){
                    Method method = methods[i];
                    if(!method.getName().startsWith("get")) continue;
                    if(method.getName().startsWith("getClass")) continue;
                    if(method.getParameterTypes().length>0) continue;
                    
                    int modifier = method.getModifiers(); 
                    if(Modifier.isAbstract(modifier)) continue;
                    if(Modifier.isNative(modifier)) continue;
                    
                    String fieldName = method.getName().substring(3,4).toLowerCase() + method.getName().substring(4);
                    try{
                            Object fieldValue = method.invoke(obj,new Object[]{});
                            info.append(createString(fieldName,className(method.getReturnType()),fieldValue,indent+2,limit));
                    }catch(Exception e){
                        info.append(space(indent+2)+fieldName+":"+className(method.getReturnType())+"("+e.toString()+":"+e.getMessage()+")\n");
                    }
                }
                
                Field[] fieldes = objClass.getFields();
                info.append(space(indent+2)+"---fieldes("+fieldes.length+")---\n");
                
                for(int i=0;i<fieldes.length;i++){
                    Field field = fieldes[i];
                    
                    try{
                        Object fieldValue = field.get(obj); 
                        info.append(createString(field.getName(),className(field.getType()),fieldValue,indent+2,limit));//field.getDeclaringClass(): declaring field's class
                    }catch(Exception e){
                        info.append(space(indent+2)+field.getName()+":"+className(field.getType())+"("+e.toString()+":"+e.getMessage()+")\n");
                    }
                }
                
                info.append(space(indent)+"}\n");
            }
                }catch(Exception e){
                    e.printStackTrace();
                }
        return info.toString();
    }
}
