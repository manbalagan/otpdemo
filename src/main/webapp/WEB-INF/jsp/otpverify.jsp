<html>

<head>
<title>Welcome - Verify OTP</title>
</head>

<body>
	Hi ${name}!! Please verify OTP.
	<br />
	<br />
	<br />
	<form action="/otpverify" method="post">
		OTP : <input type="text" name="otp" />
		<input type="submit" />
	</form>
</body>

</html>
