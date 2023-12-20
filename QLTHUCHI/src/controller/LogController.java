package controller;

import model.connection.LogModel;
import model.objects.LogO;

public class LogController {
    private LogModel logDao;
    public LogController(){
        logDao = new LogModel();
    }
    public void addLog(LogO log){
        logDao.addLog(log);
    }
}
