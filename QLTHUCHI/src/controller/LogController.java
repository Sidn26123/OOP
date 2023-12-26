package controller;

import LoginSignup.Model.User;
import java.util.List;
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
    public void addLogGroup(LogO log){
        logDao.addLogGroup(log);
    }
    public List<LogO> getLogGroup(int id_group, int month, int year){
        return logDao.getAllLogGroup(id_group, month, year);
    }
    public int getID_Log(){
        return logDao.getID_Log();
    }
    public User getInfoUserById_log(int id_log){
        return logDao.getInfoUserbyLog(id_log);
    }
    public boolean deleteLog(int id_log) {
        return logDao.deleteLog(id_log);
    }
    public void updateLogGroup(LogO log) {
        logDao.updateLogGroup(log);
    }
}
