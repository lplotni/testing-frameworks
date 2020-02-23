/**
 * Definition from
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
 * @param {number} min range start of the random int generation
 * @param {number} max range end of the random int generation
 * @return {number} generated random number
 */
function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min;
}

exports.getInt = () => getRandomInt(100, 10000000);
