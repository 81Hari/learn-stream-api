import example.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class StreamOperations
{
    private static final Logger LOG = LoggerFactory.getLogger(StreamOperations.class);
    public static void main( String[] args )
    {
        if (args.length==0){
            LOG.warn("No Parameter is passed");
            return;
        }
        int ch = args.length>=2?Integer.parseInt(args[1]):0;

        if(args[0].equalsIgnoreCase("MAP") || ch==1){
            MapDemo.runExample();
        }
        else if(args[0].equalsIgnoreCase("FLATMAP") || ch==2){
            FlatMapDemo.runExample();
        }
        else if(args[0].equalsIgnoreCase("DCS") || ch==3){
            DistinctCountSortDemo.runExample();
        } else if(args[0].equalsIgnoreCase("REDUCE") || ch==4){
            ReduceDemo.runExample();
        } else if(args[0].equalsIgnoreCase("SKIP") || args[0].equalsIgnoreCase("LIMIT") || ch==5){
            LimitAndSkipDemo.runExample();
        } else if(args[0].equalsIgnoreCase("MATCH") || ch==6){
            MatchDemo.runExample();
        } else if(args[0].equalsIgnoreCase("FIND") || ch==7){
            FindDemo.runExample();
        } else if(args[0].equalsIgnoreCase("FACTORY_METHOD") || ch==8){
            FactoryMethodsDemo.runExample();
        } else if(args[0].equalsIgnoreCase("NUMERIC_STREAM") || ch==9){
            NumericStreamDemo.runExample();
        } else if(args[0].equalsIgnoreCase("COLLECTORS") || ch==10){
            CollectorsDemo.runExample();
        }
    }
}
