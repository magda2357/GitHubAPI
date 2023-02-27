package com.restApi.foreignApi.controller;

import com.restApi.foreignApi.controller.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RepoControllerTest extends AbstractControllerTest {

    @Test
    void shouldFoundRepo() throws Exception {

        //given
        String owner = "magda2357";
        String repo = "Clinic";
        String fullName = "magda2357/Clinic";
        String description = null;
        String cloneUrl = "https://github.com/magda2357/Clinic.git";
        int stars = 0;
        String createdAt = "2022-11-29";

        //when
        mockMvc.perform(
                        get("/repos/{owner}/{repo}", owner, repo))

                //then
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value(fullName))
                .andExpect(jsonPath("$.description").value(description))
                .andExpect(jsonPath("$.cloneUrl").value(cloneUrl))
                .andExpect(jsonPath("$.stars").value(stars))
                .andExpect(jsonPath("$.createdAt").value(createdAt));
    }

    @Test
    void shouldFoundNullRepo() throws Exception {

        //given
        String owner = "##BadUserName";
        String repo = "##BadRepoName";

        LocalDate createdAt = LocalDate.of(2022, Month.NOVEMBER, 29);

        //when
        mockMvc.perform(
                        get("/repos/{owner}/{repo}", owner, repo))

                //then
                .andExpect(status().is(404))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }
}