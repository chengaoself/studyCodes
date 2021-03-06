package com.micro.testgreengao.greendao.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.micro.testgreengao.bean.one2many2.Company;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "COMPANY".
*/
public class CompanyDao extends AbstractDao<Company, Long> {

    public static final String TABLENAME = "COMPANY";

    /**
     * Properties of entity Company.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property SuccessfulManName = new Property(1, String.class, "successfulManName", false, "SUCCESSFUL_MAN_NAME");
        public final static Property CompanyName = new Property(2, String.class, "companyName", false, "COMPANY_NAME");
        public final static Property Date = new Property(3, java.util.Date.class, "date", false, "DATE");
        public final static Property Price = new Property(4, double.class, "price", false, "PRICE");
    }

    private Query<Company> successfulMan_CompanyListQuery;

    public CompanyDao(DaoConfig config) {
        super(config);
    }
    
    public CompanyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"COMPANY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"SUCCESSFUL_MAN_NAME\" TEXT NOT NULL ," + // 1: successfulManName
                "\"COMPANY_NAME\" TEXT," + // 2: companyName
                "\"DATE\" INTEGER," + // 3: date
                "\"PRICE\" REAL NOT NULL );"); // 4: price
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMPANY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Company entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindString(2, entity.getSuccessfulManName());
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(3, companyName);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
        stmt.bindDouble(5, entity.getPrice());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Company entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindString(2, entity.getSuccessfulManName());
 
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(3, companyName);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(4, date.getTime());
        }
        stmt.bindDouble(5, entity.getPrice());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Company readEntity(Cursor cursor, int offset) {
        Company entity = new Company( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getString(offset + 1), // successfulManName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // companyName
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // date
            cursor.getDouble(offset + 4) // price
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Company entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSuccessfulManName(cursor.getString(offset + 1));
        entity.setCompanyName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setPrice(cursor.getDouble(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Company entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Company entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Company entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "companyList" to-many relationship of SuccessfulMan. */
    public List<Company> _querySuccessfulMan_CompanyList(String successfulManName) {
        synchronized (this) {
            if (successfulMan_CompanyListQuery == null) {
                QueryBuilder<Company> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SuccessfulManName.eq(null));
                queryBuilder.orderRaw("T.'DATE' ASC");
                successfulMan_CompanyListQuery = queryBuilder.build();
            }
        }
        Query<Company> query = successfulMan_CompanyListQuery.forCurrentThread();
        query.setParameter(0, successfulManName);
        return query.list();
    }

}
