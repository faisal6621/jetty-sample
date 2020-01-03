package com.faisal.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faisal.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/backend")
public class BackendHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 1024862621764048151L;

    private static final Logger LOGGER = Logger.getLogger(BackendHttpServlet.class.getSimpleName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        String greeting = req.getParameter("greeting");
        ResponseDTO dto = new ResponseDTO(greeting + " from backend service.", System.currentTimeMillis());
        String hostAddress = null;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.severe(e::getMessage);
        }
        dto.setIp(hostAddress);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(resp.getWriter(), dto);
        } catch (IOException e) {
            LOGGER.severe(e::getMessage);
        }
    }

}
