package org.molgenis.framework.security;

import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.QueryRule;
import org.molgenis.util.Entity;
import org.molgenis.util.HandleRequestDelegationException;

import java.text.ParseException;
import java.util.List;

public interface Login {
    void reload(Database db) throws DatabaseException, ParseException, Exception;

    void logout(Database db) throws Exception;

    boolean isAuthenticated();

    default boolean canRead(Class<? extends Entity> entityClass) throws DatabaseException
    {
        return true;
    }

    boolean canWrite(Class<? extends Entity> entity) throws DatabaseException;

    String getUserName();

    Integer getUserId();

    boolean login(Database db, String name, String password) throws Exception, HandleRequestDelegationException;

    boolean isLoginRequired();

    // door Martijn erbij gezet 3 juli 2009
    boolean canWrite(Entity entity) throws DatabaseException;

    boolean canRead(Entity entity) throws DatabaseException;

    boolean canRead(org.molgenis.framework.ui.ScreenController<?> screen) throws DatabaseException;

    QueryRule getRowlevelSecurityFilters(Class<? extends Entity> klazz);

    String getRedirect();

    void setAdmin(List<? extends Entity> entities, Database db) throws DatabaseException;

    void setRedirect(String redirect);
}
