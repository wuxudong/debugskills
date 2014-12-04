import com.sun.btrace.BTraceUtils;
import com.sun.btrace.Profiler;
import com.sun.btrace.annotations.*;
import com.sun.btrace.AnyType;


/**
 * * User: xudong
 * * Date: 12/2/14
 * * Time: 4:51 PM
 */
@BTrace
public class PojoServiceTrace {
    public static @Property Profiler profiler = BTraceUtils.Profiling.newProfiler();

    @OnMethod(clazz = "com.mrkid.service.PojoService", method = "get", location = @Location(value = Kind.RETURN))
    public static void loginExit(AnyType[] args, @Duration long duration , @ProbeMethodName String pmn) {

        BTraceUtils.println(pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println(duration);


        BTraceUtils.Profiling.recordExit(profiler, pmn, duration);
    }



    @OnTimer(10000)
    public static void timer() {
        BTraceUtils.Profiling.printSnapshot("demo", profiler);
        BTraceUtils.Profiling.reset(profiler);

    }
}