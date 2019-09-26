package com.trial;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class regexTest {
    private Object[] parametersToTestAdd() {
        String frase = "<?QQE2Q>abcd<?QQ1EQ>xyz<?QQEAQ>";
        String frase1 = "<?AAARA>abcd<?RRRRR>xyz<?CCCRC>";
        String frase2 = "<?QQBEQ>abcd<?QQBEQ>xyz<?QQBEQ>";
        String frase3 = "<?QQZ2Q>abcd<?QQZ2Q>xyz<?QQZ2Q>";

        return new Object[] {
                frase,frase1,frase2,frase3
        };
    }

    @Parameters(method = "parametersToTestAdd")
    @Test
    public void regex(String cadena) {
        Pattern variable = Pattern.compile("([<][?])([AC-GI-WY1-5]{5})([>])");
        Matcher matcher = variable.matcher(cadena);

       while(matcher.find())
           System.out.println("found " + matcher.group(2));
        assertThat(true).isTrue();
    }
}
