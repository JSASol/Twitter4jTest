package com.jsa.sample.twitter4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Twitter4JSample {
  private static Logger logger;

  public static void main(String[] args){
    logger = LoggerFactory.getLogger(Twitter4JSample.class);

    // このファクトリインスタンスは再利用可能でスレッドセーフです
    Twitter twitter = TwitterFactory.getSingleton();

    try {
      logger.info("Screen name is "+ twitter.getAccountSettings().getScreenName());
    } catch (TwitterException e) {
      logger.error("Failed to updated the status. " + e.getMessage());
      System.exit(1);
    }

    Status status;
    try {
      status = twitter.updateStatus("TEST");
      logger.info("Successfully updated the status to [" + status.getText() + "].");
    } catch (TwitterException e) {
      logger.error("Failed to updated the status. " + e.getMessage());
    }
  }
}
