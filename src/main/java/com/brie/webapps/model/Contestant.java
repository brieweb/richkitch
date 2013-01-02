package com.brie.webapps.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;




@Entity
public class Contestant implements Serializable
{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
   //private @GeneratedValue(strategy = GenerationType.AUTO)
   private @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;

   @Version
   private @Column(name = "version")
   int version = 0;

   @Column
   private String firstName;

   @Column
   private String lastName;
   
   @Column
   private boolean wonPrize=false;



   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Contestant) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getFirstName()
   {
      return this.firstName;
   }

   public void setFirstName(final String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return this.lastName;
   }

   public void setLastName(final String lastName)
   {
      this.lastName = lastName;
   }

   public String toString()
   {
      String result = "";
      if (firstName != null && !firstName.trim().isEmpty())
         result += firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += " " + lastName;
      return result;
   }



public boolean isWonPrize() {
	return wonPrize;
}

public void setWonPrize(boolean wonPrize) {
	this.wonPrize = wonPrize;
}




}