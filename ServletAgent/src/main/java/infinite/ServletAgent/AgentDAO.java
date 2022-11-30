package infinite.ServletAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.cj.xdevapi.PreparableStatement;

public class AgentDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<Agent> showAgent() throws ClassNotFoundException, SQLException{
		
		List<Agent> agentlist = new ArrayList<Agent>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Agent agent= null;
		while(rs.next()){
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(rs.getString("gender"));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			agentlist.add(agent);
		}
		return agentlist;
	}
	
	
	public Agent searchAgent(int id) throws ClassNotFoundException, SQLException{
		
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from agent where agentid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		if(rs.next()){
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(rs.getString("gender"));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
		}
		return agent;
	}
	
	public String deleteagent(int id) throws ClassNotFoundException, SQLException{
		Agent agent = searchAgent(id);
		if(agent != null){
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from agent where agentid=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.executeUpdate();
			return "Record deleted..";
		}
		return "Employ Record Not Found...";
		}
	
	public String addAgent(Agent agent) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "insert into agent(name,city,gender,MaritalStatus,Premium)"+"values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, agent.getName());
		pst.setString(2, agent.getCity());
		pst.setString(3, agent.getGender());
		pst.setInt(4, agent.getMaritalStatus());
		pst.setDouble(5, agent.getPremium());
		pst.executeUpdate();
		return "Record Inserted..";
		
	}
	public String updateAgent(Agent agentNew) throws ClassNotFoundException, SQLException{
		Agent agent =searchAgent(agentNew.getAgentId());
		if(agent != null){
			String cmd="update agent set name =?, city=?,gender=?, maritalstatus = ?, premium=? where agentid=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, agentNew.getName());
			pst.setString(2, agentNew.getCity());
			pst.setString(3, agentNew.getGender());
			pst.setInt(4, agentNew.getMaritalStatus());
			pst.setDouble(5, agentNew.getPremium());
			pst.setInt(6, agentNew.getAgentId());
			pst.executeUpdate();
			return "Record updated..";
		}
		return "Record Not Found....";
	}
	
}
