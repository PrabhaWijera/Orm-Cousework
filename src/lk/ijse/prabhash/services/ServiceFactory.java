package lk.ijse.prabhash.services;

import lk.ijse.prabhash.services.custom.impl.Registration_Service_impl;
import lk.ijse.prabhash.services.custom.impl.Room_Service_impl;
import lk.ijse.prabhash.services.custom.impl.Student_Service_impl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }
    public  static  ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }
    public <T extends SuperService>T getService(ServiceType serviceType){
        switch (serviceType){
            case STUDENT:
                return (T) new Student_Service_impl();

            case ROOM:
                return (T)new Room_Service_impl();
/*
            case REGISTRATION:
                return (T)new Registration_Service_impl();*/

            default:
                return null;
        }
    }
}
