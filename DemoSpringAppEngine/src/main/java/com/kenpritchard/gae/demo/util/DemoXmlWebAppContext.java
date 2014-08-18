package com.kenpritchard.gae.demo.util;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.google.appengine.api.utils.SystemProperty;

/**
 * The Class DemoXmlWebAppContext.
 */
public class DemoXmlWebAppContext extends XmlWebApplicationContext {
	  
  	/* (non-Javadoc)
  	 * @see org.springframework.web.context.support.XmlWebApplicationContext#initBeanDefinitionReader(org.springframework.beans.factory.xml.XmlBeanDefinitionReader)
  	 */
  	protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) {
		    super.initBeanDefinitionReader(beanDefinitionReader);
		    if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
		      beanDefinitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
		    }
		  }
}
