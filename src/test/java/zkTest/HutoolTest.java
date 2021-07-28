package zkTest;

import cn.hutool.core.lang.Console;
import cn.hutool.script.ScriptRuntimeException;
import cn.hutool.script.ScriptUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.script.CompiledScript;
import javax.script.ScriptException;

/**
 * @author lin
 * @create 2021-07-27 23:28:20
 */


public class HutoolTest {

    @Test
    public void test(){
        String MyScript = "";
        CompiledScript script = ScriptUtil.compile("print('Script test!');");
        try {
            script.eval();
        } catch (ScriptException e) {
            throw new ScriptRuntimeException(e);
        }
        Console.log("mesd{}.{}", 1, 2);

    }

}
