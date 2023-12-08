package controller;

import model.connection.LogModel;
import model.objects.Logs;

public class LogController {
    private LogModel logDao;
    public LogController(){
        logDao = new LogModel();
    }
    public void addLog(Logs log){
        logDao.addLog(log);
    }
}
