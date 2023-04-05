package com.example.learning.moviereview.utils.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMailSender {
    private static final String WELCOME_MAIL_BODY = """
			<!DOCTYPE html>
				<html>
					<head>
					  <meta charset="utf-8">
					  <meta http-equiv="x-ua-compatible" content="ie=edge">
					  <title>Welcome Email</title>
					  <meta name="viewport" content="width=device-width, initial-scale=1">
					  <style type="text/css">
					  @media screen {
						@font-face {
						  font-family: 'Source Sans Pro';
						  font-style: normal;
						  font-weight: 400;
						  src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff) format('woff');
						}
						@font-face {
						  font-family: 'Source Sans Pro';
						  font-style: normal;
						  font-weight: 700;
						  src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'), url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff) format('woff');
						}
					  }
					  body,
					  table,
					  td,
					  a {
						-ms-text-size-adjust: 100%;
						-webkit-text-size-adjust: 100%;
					  }
					  table,
					  td {
						mso-table-rspace: 0pt;
						mso-table-lspace: 0pt;
					  }
					  img {
						-ms-interpolation-mode: bicubic;
					  }
					  a[x-apple-data-detectors] {
						font-family: inherit !important;
						font-size: inherit !important;
						font-weight: inherit !important;
						line-height: inherit !important;
						color: inherit !important;
						text-decoration: none !important;
					  }
					  div[style*="margin: 16px 0;"] {
						margin: 0 !important;
					  }
					  body {
						width: 100% !important;
						height: 100% !important;
						padding: 0 !important;
						margin: 0 !important;
					  }
					  table {
						border-collapse: collapse !important;
					  }
					  a {
						color: black;
					  }
					  img {
						height: auto;
						line-height: 100%;
						text-decoration: none;
						border: 0;
						outline: none;
					  }
					  </style>
					</head>
					<body style="background-color: #e9ecef;">
					  <div class="preheader" style="display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;">
						A preheader is the short summary text that follows the subject line when an email is viewed in the inbox.
					  </div>
					  <table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
						  <td align="center" bgcolor="#e9ecef">
							<table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
							  <tr>
								<td align="center" valign="top" style="padding: 36px 24px;">
								  <a href="#" target="_blank" rel="noopener noreferrer" style="display: inline-block;"></a>
								</td>
							  </tr>
							</table>
						  </td>
						</tr>
						<tr>
						  <td align="center" bgcolor="#e9ecef">
							<table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
							  <tr>
								<td bgcolor="#ffffff" align="left"></td>
							  </tr>
							</table>
						  </td>
						</tr>
						<tr>
						  <td align="center" bgcolor="#e9ecef">
							<table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
							  <tr>
								<td bgcolor="#ffffff" align="left" style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px;">
								  <h1 style="margin: 0 0 12px; font-size: 32px; font-weight: 400; line-height: 48px;">Welcome, {{name}}!</h1>
								  <p style="margin: 0;">Thank you for signing up with MovieDb. Welcome to the world of Movies. Enjoy!</p>
								</td>
							  </tr>
							  <tr>
								<td align="left" bgcolor="#ffffff">
								  <table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
									  <td align="center" bgcolor="#ffffff" style="padding: 12px;">
										<table border="0" cellpadding="0" cellspacing="0">
										  <tr>
											<td align="center" bgcolor="#1a82e2" style="border-radius: 6px;">
											  <a href="http://localhost:8080" target="_blank" rel="noopener noreferrer" style="display: inline-block; padding: 16px 36px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; color: #ffffff; text-decoration: none; border-radius: 6px;">View Account</a>
											</td>
										  </tr>
										</table>
									  </td>
									</tr>
								  </table>
								</td>
							  </tr>
							  <tr>
								<td align="left" bgcolor="#ffffff" style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf">
								  <p style="margin: 0;">Cheers,<br> MovieDb</p>
								</td>
							  </tr>
							</table>
						  </td>
						</tr>
						<tr>
						  <td align="center" bgcolor="#e9ecef" style="padding: 24px;">
							<table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
							  <tr>
								<td align="center" bgcolor="#e9ecef" style="padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;">
								  <p style="margin: 0;">You received this email because we received a request for creation of your account. If you didn't request account creation you can safely delete this email.</p>
								</td>
							  </tr>
							  <tr>
								<td align="center" bgcolor="#e9ecef" style="padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;">
								  <p style="margin: 0;">To stop receiving these emails, you can <a href="#" target="_blank" rel="noopener noreferrer">unsubscribe</a> at any time.</p>
								  <p style="margin: 0;">MovieDb, Chennai, India</p>
								</td>
							  </tr>
							</table>
						  </td>
						</tr>
					  </table>
					</body>
				</html>
				""";

    private final JavaMailSender javaMailSender;

    @Autowired
    public WelcomeMailSender(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String email, String name) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
        helper.setFrom("hello@moviedb.com");
        helper.setTo(email);
        helper.setSubject("Welcome to MovieDb");
        helper.setText(WELCOME_MAIL_BODY.replace("{{name}}", name), true);
        javaMailSender.send(mailMessage);
    }
}
