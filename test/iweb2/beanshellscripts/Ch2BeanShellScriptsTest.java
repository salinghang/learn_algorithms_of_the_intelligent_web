package iweb2.beanshellscripts;

import org.junit.Test;

import junit.framework.TestCase;

public class Ch2BeanShellScriptsTest extends TestCase {

    public Ch2BeanShellScriptsTest(String name) {
        super(name);
    }
    
    @Test
    public void test_EvalCh2Scripts() throws Exception {
        try {
          ScriptEvalUtils.runScripts("ch2");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
