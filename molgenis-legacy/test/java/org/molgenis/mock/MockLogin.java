package org.molgenis.mock;

import java.text.ParseException;
import java.util.List;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.framework.security.Login;
import org.molgenis.framework.ui.ScreenController;
import org.molgenis.util.Entity;
import org.molgenis.util.HandleRequestDelegationException;

/**
 * Mock implementation of the Login interface for use in unit tests
 * 
 * @author erwin
 * 
 */
public class MockLogin implements Login
{
	private boolean authenticated = false;

	public MockLogin()
	{
		super();
	}

	public MockLogin(boolean authenticated)
	{
		super();
		this.authenticated = authenticated;
	}

	@Override
	public boolean login(Database db, String name, String password) throws Exception, HandleRequestDelegationException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(Database db) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void reload(Database db) throws DatabaseException, ParseException, Exception
	{
		// TODO Auto-generated method stub

	}

	public void setAuthenticated(boolean authenticated)
	{
		this.authenticated = authenticated;
	}

	@Override
	public boolean isAuthenticated()
	{
		return authenticated;
	}

	@Override
	public String getUserName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getUserId()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoginRequired()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRead(Entity entity) throws DatabaseException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRead(ScreenController<?> screen) throws DatabaseException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canWrite(Class<? extends Entity> entityClass) throws DatabaseException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canWrite(Entity entity) throws DatabaseException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QueryRule getRowlevelSecurityFilters(Class<? extends Entity> klazz)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRedirect()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdmin(List<? extends Entity> entities, Database db) throws DatabaseException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setRedirect(String redirect)
	{
		// TODO Auto-generated method stub

	}

}
