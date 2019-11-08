package firstapp.firstapp.testapp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

interface AlertDAO {
	public UUID addAlert(Date time);
    public Date getAlert(UUID id);
}

class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();
	
    public UUID addAlert(Date time) {
    	UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }
	
    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }	
}