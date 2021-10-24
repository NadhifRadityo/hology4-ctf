from math import ceil
import random, os

p = b'[REDACTED]'
space = b'   '
blocks = ceil(len(p)/32) + random.SystemRandom().randint(1, 3)
padlength = (blocks*32) - (len(p)+6)
pad = os.urandom(padlength)
index = random.SystemRandom().randint(0, padlength)
out = [pad[:index], space, p, space, pad[index:]]

with open('padded_plaintext', 'wb') as f:
    f.write(b''.join(out))
