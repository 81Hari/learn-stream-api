import example.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * Hello world!
 *
 */
public class FunctionInterfaceExample
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionInterfaceExample.class);
    public static void main( String[] args )
    {
        if(args.length==0){
            LOGGER.warn("No Parameter is passed");
            return;
        }
        int choice = args.length >= 2?Integer.parseInt(args[2]):0;
        if(args[0].equalsIgnoreCase("CONSUMER") || choice==1 ){
            /* Consumer-Demo */
            ConsumerDemo.runExample();
            ConsumerDemo.runHandsOn();
        } else if(args[0].equalsIgnoreCase("BICONSUMER") || choice==2){
            /*BiConsumer Demo*/
            BiConsumerDemo.runExample();
            BiConsumerDemo.runHandsOn();
        } else if(args[0].equalsIgnoreCase("PREDICATE") || choice==3){
            /*Predicate Demo*/
            PredicateDemo.runExample();
            PredicateDemo.runHandsOn();
            BiPredicateDemo.runExample();
        } else if(args[0].equalsIgnoreCase("FUNCTION")|| choice==4){
            /*Function Demo*/
            FunctionDemo.runExample();
            FunctionDemo.runHandsOn();
        } else if(args[0].equalsIgnoreCase("UNARY") || args[0].equalsIgnoreCase("BINARY")|| choice==5){
            /*UNARY AND BINARY*/
            UnaryAndBinaryOperatorDemo.runExample();
        } else if(args[0].equalsIgnoreCase("SUPPLIER") || choice==6){
            /*Supplier Demo*/
            SupplierDemo.runExample();
        }  else if(args[0].equalsIgnoreCase("METHOD-REFERENCE") || choice==7){
            /*Method Reference*/
            MethodReferenceDemo.runExample();
        } else {
            LOGGER.warn("Pass Valid Parameter");
        }

















    }





}
