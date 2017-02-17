#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.rest;

/*-
 * #%L
 * IsyFact-Projektgenerator
 * %%
 * Copyright (C) 2017 Bundesverwaltungsamt (BVA), msg systems ag
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * #L%
 */

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/app-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@DatabaseSetup("eintraege.xml")
@WebAppConfiguration
public class EintragControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @ExpectedDatabase(value = "neuerEintrag.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testErstelleEintrag() throws Exception {
        String neuerEintragJson = ("{${symbol_escape}"verfasser${symbol_escape}":${symbol_escape}"Autor3${symbol_escape}",${symbol_escape}"text${symbol_escape}":${symbol_escape}"Kommentar3${symbol_escape}"}");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/eintrag").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(neuerEintragJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @ExpectedDatabase("eintraege.xml")
    public void testLeseEintraege() throws Exception {
        String expectedContent = "[{${symbol_escape}"verfasser${symbol_escape}":${symbol_escape}"Autor1${symbol_escape}",${symbol_escape}"text${symbol_escape}":${symbol_escape}"Kommentar1${symbol_escape}",${symbol_escape}"datum${symbol_escape}":${symbol_escape}"2017-01-10T11:00Z${symbol_escape}"},{${symbol_escape}"verfasser${symbol_escape}":${symbol_escape}"Autor2${symbol_escape}",${symbol_escape}"text${symbol_escape}":${symbol_escape}"Kommentar2${symbol_escape}",${symbol_escape}"datum${symbol_escape}":${symbol_escape}"2017-01-10T12:00Z${symbol_escape}"}]";

        mockMvc.perform(
                MockMvcRequestBuilders.get("/eintrag").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
