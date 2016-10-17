/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainAboutBox.java
 *
 * Created on 21/Abr/2011, 7:42:51
 */
package gui;

import persistenceCommons.SysApoio;
import gui.components.ButtonLink;
import java.io.Serializable;
import javax.swing.GroupLayout;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author jmoura
 */
public class MainAboutBox extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(MainAboutBox.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();

    /**
     * Creates new form MainAboutBox
     */
    public MainAboutBox() {
        initComponents();
        config();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lAboutTitle = new javax.swing.JLabel();
        lWebadminTitle = new javax.swing.JLabel();
        lWebsiteLink = new javax.swing.JLabel();
        lMaillistTitle = new javax.swing.JLabel();
        lMaillistLink = new javax.swing.JLabel();
        lModeratorTitle = new javax.swing.JLabel();
        lModeratorLink = new javax.swing.JLabel();
        lCommonsTitle = new javax.swing.JLabel();
        lCommons = new javax.swing.JLabel();
        lCounselorTitle = new javax.swing.JLabel();
        lClient = new javax.swing.JLabel();
        lFacebookTitle = new javax.swing.JLabel();
        lFacebookLink = new javax.swing.JLabel();
        lWebsiteTitle = new javax.swing.JLabel();
        lWebAdminLink = new javax.swing.JLabel();
        lJavaTitle = new javax.swing.JLabel();
        lJava = new javax.swing.JLabel();
        lScreenTitle = new javax.swing.JLabel();
        lScreen = new javax.swing.JLabel();
        lOsTitle = new javax.swing.JLabel();
        lOs = new javax.swing.JLabel();

        lAboutTitle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lAboutTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAboutTitle.setText(labels.getString("ABOUT.TITLE")); // NOI18N

        lWebadminTitle.setText("Site do Jogo");

        lWebsiteLink.setText("http://sites.google.com/site/clashlegends");

        lMaillistTitle.setText("Grupo de Discussão");

        lMaillistLink.setText("http://groups.google.com/group/clashoflegends");

        lModeratorTitle.setText("Moderator's email");

        lModeratorLink.setText("ClashOfLegends.theGame@gmail.com");

        lCommonsTitle.setText(labels.getString("ABOUT.COMMONS")); // NOI18N

        lCommons.setText("1.999");

        lCounselorTitle.setText(labels.getString("ABOUT.CLIENT")); // NOI18N

        lClient.setText("1.999");

        lFacebookTitle.setText("Facebook");

        lFacebookLink.setText("http://www.facebook.com/ClashOfLegends");

        lWebsiteTitle.setText("Site do Jogo");

        lWebAdminLink.setText("http://sites.google.com/site/clashlegends");

        lJavaTitle.setText(labels.getString("ABOUT.JAVA.VERSION")); // NOI18N

        lJava.setText("1.999");

        lScreenTitle.setText(labels.getString("ABOUT.SCREEN.RESOLUTION")); // NOI18N

        lScreen.setText("1.999");

        lOsTitle.setText(labels.getString("ABOUT.OS.VERSION")); // NOI18N

        lOs.setText("1.999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lWebAdminLink)
                    .addComponent(lWebsiteLink))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lFacebookLink, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lAboutTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lCounselorTitle)
                            .addComponent(lCommonsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lJavaTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lScreenTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lOsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lCommons)
                            .addComponent(lClient)
                            .addComponent(lJava)
                            .addComponent(lScreen)
                            .addComponent(lOs))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lWebadminTitle)
                            .addComponent(lMaillistTitle)
                            .addComponent(lModeratorTitle)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lModeratorLink, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lMaillistLink)))
                            .addComponent(lWebsiteTitle))
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lFacebookTitle)
                        .addGap(0, 277, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lAboutTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lWebadminTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lWebAdminLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lWebsiteTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lWebsiteLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMaillistTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMaillistLink)
                .addGap(18, 18, 18)
                .addComponent(lModeratorTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lModeratorLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lFacebookTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lFacebookLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCounselorTitle)
                    .addComponent(lClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCommonsTitle)
                    .addComponent(lCommons))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lJava)
                    .addComponent(lJavaTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lScreen)
                    .addComponent(lScreenTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lOs)
                    .addComponent(lOsTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lAboutTitle;
    private javax.swing.JLabel lClient;
    private javax.swing.JLabel lCommons;
    private javax.swing.JLabel lCommonsTitle;
    private javax.swing.JLabel lCounselorTitle;
    private javax.swing.JLabel lFacebookLink;
    private javax.swing.JLabel lFacebookTitle;
    private javax.swing.JLabel lJava;
    private javax.swing.JLabel lJavaTitle;
    private javax.swing.JLabel lMaillistLink;
    private javax.swing.JLabel lMaillistTitle;
    private javax.swing.JLabel lModeratorLink;
    private javax.swing.JLabel lModeratorTitle;
    private javax.swing.JLabel lOs;
    private javax.swing.JLabel lOsTitle;
    private javax.swing.JLabel lScreen;
    private javax.swing.JLabel lScreenTitle;
    private javax.swing.JLabel lWebAdminLink;
    private javax.swing.JLabel lWebadminTitle;
    private javax.swing.JLabel lWebsiteLink;
    private javax.swing.JLabel lWebsiteTitle;
    // End of variables declaration//GEN-END:variables

    private void config() {
        log.info(System.getProperties().toString());
        lClient.setText("1." + SysApoio.getVersionClash("version_counselor"));
        lCommons.setText("1." + SysApoio.getVersionClash("version_commons"));
        lJava.setText(SysApoio.getVersionJava());
        lOs.setText(SysApoio.getVersionOs());
        lScreen.setText(SysApoio.getScreenSize());
        lAboutTitle.setText(labels.getString("ABOUT.TITLE"));
        lWebsiteTitle.setText(labels.getString("ABOUT.WEB.TITLE"));
        lWebadminTitle.setText(labels.getString("ABOUT.WEBADMIN.TITLE"));
        lMaillistTitle.setText(labels.getString("ABOUT.MAIL.TITLE"));
        lCounselorTitle.setText(labels.getString("ABOUT.CLIENT"));
        lCommonsTitle.setText(labels.getString("ABOUT.COMMONS"));
        lModeratorTitle.setText(labels.getString("ABOUT.MODERATOR.TITLE"));
        lFacebookTitle.setText(labels.getString("ABOUT.FACEBOOK.TITLE"));

        try {
            GroupLayout parLayout = (GroupLayout) jPanel1.getLayout();
            ButtonLink webAdmin = new ButtonLink(labels.getString("ABOUT.WEBADMIN.LINK"), labels.getString("ABOUT.WEBADMIN.LINK"));
            parLayout.replace(lWebAdminLink, webAdmin);
            ButtonLink webLink = new ButtonLink(labels.getString("ABOUT.WEB.LINK"), labels.getString("ABOUT.WEB.LINK"));
            parLayout.replace(lWebsiteLink, webLink);
            ButtonLink mailLink = new ButtonLink(labels.getString("ABOUT.MAIL.LINK"), labels.getString("ABOUT.MAIL.LINK"));
            parLayout.replace(lMaillistLink, mailLink);
            ButtonLink moderatorLink = new ButtonLink(labels.getString("ABOUT.MODERATOR.LINK"), "mailto:" + labels.getString("ABOUT.MODERATOR.LINK"));
            parLayout.replace(lModeratorLink, moderatorLink);
            ButtonLink facebookLink = new ButtonLink(labels.getString("ABOUT.FACEBOOK.LINK"), labels.getString("ABOUT.FACEBOOK.LINK"));
            parLayout.replace(lFacebookLink, facebookLink);
        } catch (Exception e) {
            lMaillistLink.setText(labels.getString("ABOUT.MAIL.LINK"));
            lWebAdminLink.setText(labels.getString("ABOUT.WEBADMIN.LINK"));
            lWebsiteLink.setText(labels.getString("ABOUT.WEB.LINK"));
            lModeratorLink.setText(labels.getString("ABOUT.MODERATOR.LINK"));
        }
    }
}
