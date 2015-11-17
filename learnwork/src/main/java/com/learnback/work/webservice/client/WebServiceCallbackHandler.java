
/**
 * WebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.learnback.work.webservice.client;

    /**
     *  WebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for postSingle method
            * override this method for handling normal response from postSingle operation
            */
           public void receiveResultpostSingle(
                    com.learnback.work.webservice.client.WebServiceStub.PostSingleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postSingle operation
           */
            public void receiveErrorpostSingle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postGroup method
            * override this method for handling normal response from postGroup operation
            */
           public void receiveResultpostGroup(
                    com.learnback.work.webservice.client.WebServiceStub.PostGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postGroup operation
           */
            public void receiveErrorpostGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findResponse method
            * override this method for handling normal response from findResponse operation
            */
           public void receiveResultfindResponse(
                    com.learnback.work.webservice.client.WebServiceStub.FindResponseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findResponse operation
           */
            public void receiveErrorfindResponse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBusinessType method
            * override this method for handling normal response from getBusinessType operation
            */
           public void receiveResultgetBusinessType(
                    com.learnback.work.webservice.client.WebServiceStub.GetBusinessTypeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBusinessType operation
           */
            public void receiveErrorgetBusinessType(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setMedias method
            * override this method for handling normal response from setMedias operation
            */
           public void receiveResultsetMedias(
                    com.learnback.work.webservice.client.WebServiceStub.SetMediasResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setMedias operation
           */
            public void receiveErrorsetMedias(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountInfo method
            * override this method for handling normal response from getAccountInfo operation
            */
           public void receiveResultgetAccountInfo(
                    com.learnback.work.webservice.client.WebServiceStub.GetAccountInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountInfo operation
           */
            public void receiveErrorgetAccountInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyPassword method
            * override this method for handling normal response from modifyPassword operation
            */
           public void receiveResultmodifyPassword(
                    com.learnback.work.webservice.client.WebServiceStub.ModifyPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyPassword operation
           */
            public void receiveErrormodifyPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for post method
            * override this method for handling normal response from post operation
            */
           public void receiveResultpost(
                    com.learnback.work.webservice.client.WebServiceStub.PostResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from post operation
           */
            public void receiveErrorpost(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getResponse method
            * override this method for handling normal response from getResponse operation
            */
           public void receiveResultgetResponse(
                    com.learnback.work.webservice.client.WebServiceStub.GetResponseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getResponse operation
           */
            public void receiveErrorgetResponse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMOMessage method
            * override this method for handling normal response from getMOMessage operation
            */
           public void receiveResultgetMOMessage(
                    com.learnback.work.webservice.client.WebServiceStub.GetMOMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMOMessage operation
           */
            public void receiveErrorgetMOMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findReport method
            * override this method for handling normal response from findReport operation
            */
           public void receiveResultfindReport(
                    com.learnback.work.webservice.client.WebServiceStub.FindReportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findReport operation
           */
            public void receiveErrorfindReport(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getReport method
            * override this method for handling normal response from getReport operation
            */
           public void receiveResultgetReport(
                    com.learnback.work.webservice.client.WebServiceStub.GetReportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getReport operation
           */
            public void receiveErrorgetReport(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for postMass method
            * override this method for handling normal response from postMass operation
            */
           public void receiveResultpostMass(
                    com.learnback.work.webservice.client.WebServiceStub.PostMassResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from postMass operation
           */
            public void receiveErrorpostMass(java.lang.Exception e) {
            }
                


    }
    