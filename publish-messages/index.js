const amqp = require('amqplib/callback_api');
const randomWords = require('random-words');
const randomInts = require('./random-ints');


if (! process.argv[2]) {
  console.error('Please define how many messages should be send to the queue');
  process.exit(1);
} else {
  const amount = parseInt(process.argv[2]);

  amqp.connect('amqp://localhost', (error0, connection) => {
    if (error0) {
      console.error(error0);
      throw error0;
    }
    connection.createChannel((error1, channel) => {
      if (error1) {
        console.error(error1);
        throw error1;
      }
      const queue = 'bookings';

      channel.assertQueue(queue, {
        durable: false,
      });

      const generateMsg = () => {
        return {
          serviceId: `${randomInts.getInt()}`,
          serviceName: randomWords(),
          servicePrice: randomInts.getInt(),
          user: `${randomWords()}@example.com`,
        };
      };
      const send = (i, msg) =>{
        const msgString = JSON.stringify(msg);
        channel.sendToQueue(queue, Buffer.from(msgString));
        console.log(` [${i}] Sent ${msgString}`);
      };

      Array(amount).fill().map((_, i) => send(i, generateMsg()));
    });

    setTimeout(function() {
      connection.close();
      process.exit(0);
    }, 500);
  });
}
