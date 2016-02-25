# Spring-transaction-Example

# 关于之前:mysql.defaultAutoCommit=false 
# 出现false时无法commit; true时无法Rollback
#原因时    @Transactional 添加在了Test方法上,与
<!-- 配置业务bean：PersonServiceBean -->
  <bean id="personServiceImpl" class="com.upsmart.mysql.PersonServiceImpl">
    <!-- 向属性dataSource注入数据源 -->
    <property name="dataSource" ref="dataSource"></property>
  </bean>

#中配置的不一致,无法调用spring事物.
