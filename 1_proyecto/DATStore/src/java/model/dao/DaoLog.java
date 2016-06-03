package model.dao;

import com.dto.Log;
import java.util.List;

public interface DaoLog {
    public List<Log> logQry();
    public String logIns(Log log);
    public String logDel(Integer idlog);
    public Log logGet(Integer idlog);
    public String logUpd(Log log);
}
