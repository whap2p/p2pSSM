import java.util.Map;
import java.util.TreeMap;

/**
 * @Author 何卓（Lip·Gallager）
 * @Company yiang公司
 * @ClassName SsmTableUtil
 * @Description //TODO 根据对应的表名生成对应的配置table
 * 使用有序的TreeMap集合，保证了打印的语句与填写的顺序是一样的，请根据自己的代码规范填写。
 * 使用请看：
 * 1、在main方法里填写对应的表名与类名，一对一填写【键 - 值】 == 【表名 - 实体类名】
 * 2、运行
 * 3、复制粘贴代码
 * 注意：底部有运行列子后展示的代码。。
 * @CreateDate 2019-01-18 16:26
 * @Version 1.0
 */
public class SsmTableUtil {

    private static Map<String, String> map = new TreeMap<>();//定义有序的TreeMap集合

    /**
     * @MethodName put 包装map的添加方法，更直观填写数据
     * @Description //TODO 写该方法是为了更直观的填写数据，因为有className和tableName的提示
     * @CreateDate 11:16 2019/1/19
     * @Params [tableName, className] 【表名，实体类名】
     * @Return void
     **/
    public static void put(String tableName, String className) {
        map.put(tableName, className);
    }

    public static void main(String[] args) {
        //数据初始化，key为数据库表名，value为实体类命名，（实体类命名要驼峰式哦！）
        //put("","");
        //--------------------填写对应数据层
        put("admin", "Admin");
        put("approveitem", "Approveitem");
        put("bankcard", "Bankcard");
        put("banks", "Banks");
        put("biao", "Biao");
        put("borrowcord", "Borrowcord");
        put("borrowmoney", "Borrowmoney");
        put("certification", "Certification");
        put("certifrecord", "Certifrecord");
        put("clapplyfor", "clapplyfor");
        put("creditlimit", "Creditlimit");
        put("approveitem", "Approveitem");
        put("dept", "Dept");
        put("details", "Details");
        put("dope", "Dope");
        put("employee", "Employee");
        put("feedback", "Feedback");
        put("group", "Group");
        put("inactiveuser", "Inactiveuser");
        put("integral", "Integral");
        put("investinfo", "Investinfo");
        put("investstat", "Investstat");
        put("limi", "Limi");
        put("lockusertable", "Lockusertable");
        put("log", "Log");
        put("managegroup", "Managegroup");
        put("notice", "Notice");
        put("post", "Post");
        put("poundage", "Poundage");
        put("product", "Product");
        put("product_copy1", "Product_copy1");
        put("product_copy2", "Product_copy2");
        put("recharge", "Recharge");
        put("referee", "Referee");
        put("tender", "Tender");
        put("test", "Test");
        put("testtb", "Testtb");
        put("testtb1", "Testtb1");
        put("trade", "Trade");
        put("userauditor", "Userauditor");
        put("userreport", "Userreport");
        put("users", "Users");
        put("vip", "Vip");
        put("withdrawal", "Withdrawal");
        System.out.println("asdf已填写的对应表格数据量大小：" + map.size());

        //--------------------填写对应数据层
//        run();//运行生成代码的方法
    }


    /**
     * @MethodName run
     * @Description //TODO 通过遍历有序集合拼接配置代码
     * @CreateDate 10:57 2019/1/19
     * @Params []
     * @Return void
     **/
    public static void run() {
        System.out.println("已填写的对应表格数据量大小：" + map.size());
        StringBuilder sb = new StringBuilder();//承载代码块
        String tableName = "";//表名
        String className = "";//实体类名
        int count = 0;//记录生成的数量
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tableName = entry.getKey();
            className = entry.getValue();
            count++;
            if (tableName.equals("") || tableName == null || className.equals("") || className == null) {
                throw new NullPointerException("信息填写错啦！有为空的key 或者 value！重新填！！！！");
            }
            System.out.println("添加第" + (count) + "个对象信息：" + "表名【" + tableName + "】实体类名【" + className + "】");
            //在每个配置表记录上添加的配置注释信息，可以选择性添加 【<!--配置表["tableName"]的信息-->】
            sb.append("<!--配置第" + (count) + "个表[" + tableName + "]的信息-->\r\n");
            sb.append("<table schema=\"\" tableName=\"" + tableName + "\" domainObjectName=\"" + className
                    + "\" enableCountByExample=\"false\" enableDeleteByExample=\"false\" enableSelectByExample=\"false\" enableUpdateByExample=\"false\">");
            sb.append("<property name=\"useActualColumnNames\" value=\"true\"/>");//是否使生成的实体类代码信息与数据库字段一致
            sb.append("</table>");
            sb.append("\r\n");//每添加一个则换行
        }
        System.out.println("已完成的对应数据量大小：[" + count + "]");

        //匹配完成数是否等于填写数，
        if (count == map.size()) {
            System.out.println("已将填入的数据全部完成，请将代码复制粘贴入配置文件");
        } else {
            System.err.println("填入的数据与完成数有偏差！请检测填写是否有误！！！");
        }

        System.out.println("*******************************复制代码区域开始，请copy*******************************");
        System.out.println(sb);//打印最终copy入配置文件的文本
        System.out.println("*******************************复制代码区域结束，OK！*******************************");
    }

//  <table schema="" tableName="t_shiro_user_role" domainObjectName="UserRole"
//    enableCountByExample="false" enableDeleteByExample="false"
//    enableSelectByExample="false" enableUpdateByExample="false">
//            <property name="useActualColumnName" value="true"/>
//             <columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />
//        </table>
    //Demo运行的示列代码
    //<!--配置表[t_hibernate_book]的信息-->
    //<table schema="" tableName="t_hibernate_book" domainObjectName="Book" enableCountByExample="false"
    // enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false">
    // <property name="useActualColumnNames" value="true"/></table>
    //<!--配置表[t_hibernate_book_category]的信息-->
    //<table schema="" tableName="t_hibernate_book_category" domainObjectName="BookCategory" enableCountByExample="false" enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false"><property name="useActualColumnNames" value="true"/></table>
    //<!--配置表[t_hibernate_category]的信息-->
    //<table schema="" tableName="t_hibernate_category" domainObjectName="Category" enableCountByExample="false" enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false"><property name="useActualColumnNames" value="true"/></table>
    //<!--配置表[t_hibernate_order]的信息-->
    //<table schema="" tableName="t_hibernate_order" domainObjectName="Order" enableCountByExample="false" enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false"><property name="useActualColumnNames" value="true"/></table>
    //<!--配置表[t_hibernate_order_item]的信息-->
    //<table schema="" tableName="t_hibernate_order_item" domainObjectName="OrderItem" enableCountByExample="false" enableDeleteByExample="false" enableSelectByExample="false" enableUpdateByExample="false"><property name="useActualColumnNames" value="true"/></table>
}

