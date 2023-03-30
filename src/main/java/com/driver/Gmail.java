package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    LinkedList<Mail> inbox;

    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    List<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new LinkedList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        Mail newEmail = new Mail(date, sender,message);

        if (inbox.size() == this.inboxCapacity) {

            Mail oldestMail = inbox.remove();
            trash.add(oldestMail);
        }

        inbox.add(newEmail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for (Mail mail: inbox) {
            if (mail.getMessage().equals(message)) {
                inbox.remove(mail);
                trash.add(mail);

                break;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        if (inbox == null) return null;

        // Else, return the message of the latest mail present in the inbox
        return inbox.getLast().getMessage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        if (inbox == null) return null;

        // Else, return the message of the oldest mail present in the inbox
        return inbox.getFirst().getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int numberOfMails = 0;
        for (Mail mail: inbox) {
            int check1 = start.compareTo(mail.getDate());
            int check2 = mail.getDate().compareTo(end);

            if (check1 <= 0 && check2 <=0) {
                numberOfMails++;
            }
        }

        return numberOfMails;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
       if (trash != null) {

//           for (int i = 0; i <= trash.size(); i++) {
//               Mail mail = trash.get(i);
//               trash.remove(mail);
//           }
           trash.removeAll(trash);
       }
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
