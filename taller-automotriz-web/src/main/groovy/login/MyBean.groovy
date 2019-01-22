package login

import org.springframework.beans.factory.annotation.Value

class MyBean {


    public String myValue;

    def foo() {
        return myValue;
    }

    def setMyValue(newValue){
        myValue = newValue
    }
}
