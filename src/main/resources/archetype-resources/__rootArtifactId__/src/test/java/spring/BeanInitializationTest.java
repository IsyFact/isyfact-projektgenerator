#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.spring;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.dbcp.BasicDataSource;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.core.admin.Administration;
import ${package}.core.auskunft.Auskunft;
import ${package}.core.auskunft.impl.AwfRegisterEintragSuchen;
import ${package}.service.admin.httpinvoker.v1_0.impl.AdministrationExceptionFassade;
import ${package}.service.auskunft.httpinvoker.v1_0.impl.AuskunftExceptionFassade;

import de.bund.bva.pliscommon.konfiguration.common.impl.ReloadablePropertyKonfiguration;
import de.bund.bva.pliscommon.ueberwachung.common.jmx.ServiceStatistikMBean;
import de.bund.bva.pliscommon.ueberwachung.common.jmx.StatusMonitorMBean;
import de.bund.bva.pliscommon.util.spring.MessageSourceHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:resources/spring/application.xml",
        "classpath:resources/spring/service/remoting-servlet.xml",
        "classpath:resources/spring/service/service.xml",
        "classpath:resources/spring/timertasks.xml",
        "classpath:resources/spring/ueberwachung.xml"})
public class BeanInitializationTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /*
     * spring-context.xml relevanten Beans.
     */
    @Test
    public void testExistiertPropertyPlaceholderConfigurerBean() {
        assertNotNull(applicationContext.getBean(PropertyPlaceholderConfigurer.class));
    }

    @Test
    public void testExistiertMessageSourceHolderBean() {
        assertNotNull(applicationContext.getBean(MessageSourceHolder.class));
    }

    /*
     * querschnitt/dozer.xml relevanten Beans.
     */
    @Test
    public void testExistiertDozerBeanMapperBean() {
        assertNotNull(applicationContext.getBean(DozerBeanMapper.class));
    }

    /*
     * querschnitt/konfiguration.xml relevanten Beans.
     */
    @Test
    public void testExistiertReloadablePropertyKonfigurationBean() {
        assertNotNull(applicationContext.getBean(ReloadablePropertyKonfiguration.class));
    }

    /*
     * persistence/jpa.xml relevanten Beans.
     */
    @Test
    public void testExistiertLocalContainerEntityManagerFactoryBeanBean() {
        assertNotNull(applicationContext.getBean(LocalContainerEntityManagerFactoryBean.class));
    }

    @Test
    public void testExistiertBasicDataSourceBean() {
        assertNotNull(applicationContext.getBean(BasicDataSource.class));
    }

    @Test
    public void testExistiertJpaTransactionManagerBean() {
        assertNotNull(applicationContext.getBean(JpaTransactionManager.class));
    }

    @Test
    public void testExistiertPersistenceAnnotationBeanPostProcessorBean() {
        assertFalse(applicationContext.getBeansOfType(PersistenceAnnotationBeanPostProcessor.class).isEmpty());
    }

    @Test
    public void testExistiertPersistenceExceptionTranslationPostProcessorBean() {
        assertNotNull(applicationContext.getBean(PersistenceExceptionTranslationPostProcessor.class));
    }

    /*
     * core/auskunft.xml relevanten Beans.
     */
    @Test
    public void testExistiertAuskunftImplBean() {
        assertNotNull(applicationContext.getBean(Auskunft.class));
    }

    @Test
    public void testExistiertAwfRegisterEintragSuchenBean() {
        assertNotNull(applicationContext.getBean(AwfRegisterEintragSuchen.class));
    }

    /*
     * service/remoting-servlet.xml relevanten Beans.
     */
    @Test
    public void testExistiertAuskunftBean_v1_0() {
        assertNotNull(applicationContext.getBean("/AuskunftBean_v1_0"));
    }

    @Test
    public void testExistiertAdminBean_v1_0() {
        assertNotNull(applicationContext.getBean("/AdminBean_v1_0"));
    }

    /*
     * service/service.xml relevanten Beans.
     */
    @Test
    public void testExistiertAuskunftExceptionFassadeBean() {
        assertNotNull(applicationContext.getBean(AuskunftExceptionFassade.class));
    }

    @Test
    public void testExistiertAdministrationExceptionFassadeBean() {
        assertNotNull(applicationContext.getBean(AdministrationExceptionFassade.class));
    }

    /*
     * timertasks.xml relevanten Beans.
     */
    @Test
    public void testExistiertWatchdogTaskBean() {
        assertNotNull(applicationContext.getBean("watchdogTask"));
    }

    @Test
    public void testExistiertKonfigurationPollingTaskBean() {
        assertNotNull(applicationContext.getBean("konfigurationPollingTask"));
    }

    @Test
    public void testExistiertScheduledExecutorFactoryBeanBean() {
        assertNotNull(applicationContext.getBean(ScheduledExecutorFactoryBean.class));
    }

    /*
     * ueberwachung.xml relevanten Beans.
     */
    @Test
    public void testExistiertAdministrationBean() {
        assertNotNull(applicationContext.getBean(Administration.class));
    }

    @Test
    public void testExistiertMBeanExporterBean() {
        assertNotNull(applicationContext.getBean(MBeanExporter.class));
    }

    @Test
    public void testExistiertAuskunftMonitorBean() {
        assertNotNull(applicationContext.getBean(ServiceStatistikMBean.class));
    }

    @Test
    public void testExistiertWatchdogMonitorBean() {
        assertNotNull(applicationContext.getBean(StatusMonitorMBean.class));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
