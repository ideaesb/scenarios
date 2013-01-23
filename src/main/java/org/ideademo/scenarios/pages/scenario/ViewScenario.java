package org.ideademo.scenarios.pages.scenario;


import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

import org.ideademo.scenarios.entities.Scenario;


public class ViewScenario
{
	
  @PageActivationContext 
  @Property
  private Scenario entity;
  
  
  void onPrepareForRender()  {if(this.entity == null){this.entity = new Scenario();}}
  void onPrepareForSubmit()  {if(this.entity == null){this.entity = new Scenario();}}
}
