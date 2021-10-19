import base64

base64_message = 'VGhpcyBpcyBiYXNlNjQgZW5jb2RpbmcsIGlzIG5vdCBhIGNoaXBlciBidXQgb25seSBhIHdheSB0byByZXByZXNlbnQgYmluYXJ5IGRhdGEgaW4gYW4gQVNDSUkgc3RyaW5nLg=='
base64_bytes = base64_message.encode('ascii')
message_bytes = base64.b64decode(base64_bytes)
message = message_bytes.decode('ascii')

print(message)
